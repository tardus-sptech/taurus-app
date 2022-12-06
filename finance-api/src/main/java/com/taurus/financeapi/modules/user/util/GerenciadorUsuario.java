package com.taurus.financeapi.modules.user.util;

import com.taurus.financeapi.modules.user.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public class GerenciadorUsuario {

    private static ListaObj<UserResponse> listaLogados = new ListaObj<>(50);

    public static void login(UserResponse usuario) {
        listaLogados.adiciona(usuario);
    }

    public static boolean logoff(Integer idUsuario) {
        return listaLogados.removeElemento(new UserResponse(idUsuario, null, null, null, null, null, null, null, null, null, null));
    }

    public static List<UserResponse> listarUsuariosLogados() {
        return listaLogados.transformarEmLista();
    }

    public static boolean isEmpty() {
        return listaLogados.getTamanho() == 0;
    }

	public static Optional<UserResponse> buscaUsuarioLogado(Integer idUsuario){
		int indice = listaLogados.busca(new UserResponse(idUsuario, null, null, null, null, null, null, null, null, null, null));

		if(indice == -1){
			return Optional.ofNullable(null);
		}
		return Optional.ofNullable(listaLogados.getElemento(indice));
	}

}
