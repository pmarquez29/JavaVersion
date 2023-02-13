package arquitectura.software.demo2.api;

import arquitectura.software.demo2.bl.CurrencyBl;
import arquitectura.software.demo2.dto.CurrencyDto;
import arquitectura.software.demo2.dto.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("api/v1/currency")

public class CurrencyApi {
    private CurrencyBl currencyBl;

    public CurrencyApi(CurrencyBl currencyBl) {
        this.currencyBl = currencyBl;
    }

    @GetMapping("/get")
    public ResponseEntity<Object> get(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount) throws Exception {
        CurrencyDto currencyDto = currencyBl.get(from, to,amount);
        ResponseDto<CurrencyDto> responseDto = new ResponseDto<CurrencyDto>(currencyDto,true,"Success");
        return ResponseEntity.ok(responseDto);
    }
}
