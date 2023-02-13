package arquitectura.software.demo2.exceptions;

import arquitectura.software.demo2.dto.ResponseDto;
import org.springframework.http.ResponseEntity;

public class Controller {

    public ResponseEntity<ResponseDto> zeroException(IllegalArgumentException e) {
        ResponseDto responseDto = new ResponseDto(null, false, e.getMessage());
        return ResponseEntity.badRequest().body(responseDto);
    }

}
