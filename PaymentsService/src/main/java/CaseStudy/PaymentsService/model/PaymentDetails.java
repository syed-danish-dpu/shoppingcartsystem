package CaseStudy.PaymentsService.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Payments")
public class PaymentDetails {
	    @Id
	    private int orderId;
		private int amount;
		private LocalDateTime dateTime;
	    private String paymentStatus;
	    private String txId;
	    
	    
		public PaymentDetails(LocalDateTime dateTime) {
			super();
			this.dateTime = dateTime;
		}
		public LocalDateTime getDateTime() {
			return dateTime;
		}
		public void setDateTime(LocalDateTime dateTime) {
			this.dateTime = dateTime;
		}
		public PaymentDetails(int orderId, int amount, String paymentStatus, String txId) {
			this.orderId = orderId;
			this.amount = amount;
			this.paymentStatus = paymentStatus;
			this.txId = txId;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getPaymentStatus() {
			return paymentStatus;
		}
		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}
		public String getTxId() {
			return txId;
		}
		public void setTxId(String txId) {
			this.txId = txId;
		}
		@Override
		public String toString() {
			return "PaymentDetails [dateTime=" + dateTime + "]";
		}
	    

}
