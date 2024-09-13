package common;

import java.time.LocalDateTime;

public class CommonField {
	private LocalDateTime insertedDate;
	private LocalDateTime updatedDate;
	
	public LocalDateTime getInsertedDate() {
		return insertedDate;
	}
	public void setInsertedDate(LocalDateTime insertedDate) {
		this.insertedDate = insertedDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}	
}
