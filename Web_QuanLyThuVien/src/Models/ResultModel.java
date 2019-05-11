package Models;

public class ResultModel {
	private boolean Status;
	private String Message;
	
	public ResultModel(boolean status, String message) {
		super();
		Status = status;
		Message = message;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
}
