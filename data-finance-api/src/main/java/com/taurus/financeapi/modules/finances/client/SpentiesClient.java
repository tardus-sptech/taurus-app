package com.taurus.financeapi.modules.finances.client;

import com.taurus.financeapi.modules.finances.dto.FinanceSpentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "spentiesClient",
        contextId = "spentiesClient",
        url = "${app-config.services.spenties}"
)
public interface SpentiesClient {
    @GetMapping("spenties/{spentieId}")
    Optional<FinanceSpentResponse> findFinanceBySpentId(@PathVariable Integer spentId);
}
