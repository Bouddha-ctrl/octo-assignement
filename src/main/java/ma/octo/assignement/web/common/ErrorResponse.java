package ma.octo.assignement.web.common;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorResponse {

	private int status;
	private String message;
	private Date time;


}
