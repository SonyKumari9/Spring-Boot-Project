package ecommerce.example.ecommerce.model;

public class NotificationModel {
	
	private String message;
    private String timestamp;

    public NotificationModel(String message, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
    
    

}
