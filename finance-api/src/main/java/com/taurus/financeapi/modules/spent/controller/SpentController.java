package com.taurus.financeapi.modules.spent.controller;

import com.taurus.financeapi.modules.adt.Fila;
import com.taurus.financeapi.modules.category.service.CategoryService;
import com.taurus.financeapi.modules.gain.service.GainService;
import com.taurus.financeapi.modules.spent.dto.SpentRequest;
import com.taurus.financeapi.modules.spent.dto.SpentResponse;
import com.taurus.financeapi.modules.spent.model.Spent;
import com.taurus.financeapi.modules.spent.service.SpentService;
import com.taurus.financeapi.modules.user.model.User;
import com.taurus.financeapi.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/spenties")
public class SpentController {

    @Autowired
    private SpentService spentService;

    @Autowired
    private GainService gainService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    private Fila filaSpent = new Fila(10);

    @GetMapping("/user/{idUser}")
    public List<SpentResponse> getSpentByUserId(@PathVariable Integer idUser) {
        return spentService.findByUserId(idUser);
    }

    @PostMapping
    public SpentResponse save(@RequestBody SpentRequest spent) {
        return spentService.save(spent);
    }

    @GetMapping
    public List<SpentResponse> findAll() {
        return spentService.findAll();
    }

    @GetMapping("{id}")
    public SpentResponse findById(@PathVariable Integer id) {
        return spentService.findByIdResponse(id);
    }

    @GetMapping("/name/{name}")
    public List<SpentResponse> findByName(@PathVariable String name) {
        return spentService.findByName(name);
    }

    @GetMapping("/category/{categoryId}")
    public List<SpentResponse> findByCategoryId(@PathVariable Integer categoryId) {
        return spentService.findByCategoryId(categoryId);
    }

//    @PutMapping("{id}")
//    public SpentResponse update(@RequestBody SpentRequest request,
//                                  @PathVariable Integer id) {
//        return spentService.update(request, id);
//    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity<Spent> delete(@PathVariable Integer id) {
        spentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/user/sum/{categoryId}/{userId}")
    public Double sumSpentfindByUserId(@PathVariable Integer categoryId, @PathVariable Integer userId) {
        return spentService.sumSpentfindByUserId(categoryId, userId);
    }

        @GetMapping("/user/sum/{userId}")
    public Double sumSpentfindByUserId(@PathVariable Integer userId) {
        return spentService.sumSpentfindByUserId(userId);
    }

    @GetMapping("/user/verify-fila")
    public ResponseEntity<Spent[]> verifyFila() {
        if (!filaSpent.isEmpty()) {
            return ResponseEntity.status(200).body(filaSpent.getFila());
        }
        return ResponseEntity.status(204).build();
    }

    @PostMapping(value = "/user/file-txt", consumes = "text/*")
    public ResponseEntity<Spent> salvaTxt(
            @RequestBody byte[] fileTxt
    ) throws UnsupportedEncodingException {

        String fileString = new String(fileTxt, "UTF-8");

        Spent newSpent = new Spent();

        String headerInfo = fileString.substring(1, 22);
        String name = fileString.substring(22, 42);
        Double valeu = Double.valueOf(fileString.substring(42, 52));
        Integer idCategory = Integer.valueOf(fileString.substring(52, 62));
        Integer idUer = Integer.valueOf(fileString.substring(62, 72));

        System.out.println(name);
        System.out.println(valeu);
        System.out.println(idCategory);
        System.out.println(idUer);

        newSpent.setName(name);
        newSpent.setValue(valeu);
        newSpent.setCategory(categoryService.findById(idCategory));
        newSpent.setUser(userService.findById(idUer));

        filaSpent.insert(newSpent);

        return ResponseEntity.status(201).body(newSpent);
    }

    @PostMapping("/user/file-txt/save")
    public ResponseEntity<String> salvaTxt() {

        if (!filaSpent.isEmpty()) {
            Spent newSpent = filaSpent.poll();
            spentService.saveSpentTxt(newSpent);
            return ResponseEntity.status(201).body
                    (
                            String.format("Gasto %s no valor de R$%s salvo com sucesso!",
                                    newSpent.getName().replace(" ", ""), newSpent.getValue())
                    );
        }

        return ResponseEntity.status(200).body("Não há gastos registrados na fila");
    }

    @GetMapping(value = "/user/file-txt/{idUser}", produces = "text/plain")
    public ResponseEntity<byte[]> buscaArquivoTxt(@PathVariable Integer idUser) {

        User user = userService.findById(idUser);

        String
                id = String.valueOf(user.getId()),
                name = user.getName(),
                email = user.getEmail(),
                cpf = user.getCpf(),
                birthDay = String.valueOf(user.getBirthDate()).substring(0, 10),
                valueInAccount = String.valueOf(user.getValueInAccount()),
                sumSpenties = String.valueOf(spentService.sumSpentfindByUserId(idUser)),
                sumGains = String.valueOf(gainService.sumGainfindByUserId(idUser)),
                totalTransactions = String.valueOf(gainService.countGains(idUser) + spentService.countSpenties(idUser)),
                arquivoFormatado = "";

        arquivoFormatado += "01";
        arquivoFormatado += "RELATORIO";
        arquivoFormatado += LocalDateTime.now() + " ".repeat(5);
        arquivoFormatado += "01";
        arquivoFormatado += id + " ".repeat(4 - id.length());
        arquivoFormatado += name + " ".repeat(30 - name.length());
        arquivoFormatado += email + " ".repeat(30 - email.length());
        arquivoFormatado += cpf + " ".repeat(15 - cpf.length());
        arquivoFormatado += birthDay + " ".repeat(12 - birthDay.length());
        arquivoFormatado += valueInAccount + " ".repeat(10 - valueInAccount.length());
        arquivoFormatado += sumSpenties + " ".repeat(10 - sumSpenties.length());
        arquivoFormatado += sumGains + " ".repeat(10 - sumGains.length());
        arquivoFormatado += totalTransactions + " ".repeat(10 - totalTransactions.length());


        byte[] arquivoTxt = arquivoFormatado.getBytes(StandardCharsets.UTF_8);

        return ResponseEntity
                .status(200)
                .header("content-disposition", "attachment; filename=\"item.txt\"")
                .body(arquivoTxt);
    }

}
