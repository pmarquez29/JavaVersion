package arquitectura.software.demo2.dto;

import java.math.BigDecimal;

public class CurrencyDto {

    private boolean success;
    private RequestDto query;
    private InfoDto info;
    private String date;
    private BigDecimal result;

    public CurrencyDto() {
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo(InfoDto info) {
        this.info = info;
    }

    public RequestDto getQuery() {
        return query;
    }

    public void setQuery(RequestDto query) {
        this.query = query;
    }
    @Override
    public String toString(){
        return "success: "+success+" date: "+date+" result: "+result+" info: "+info+" query: "+query;
    }
}
