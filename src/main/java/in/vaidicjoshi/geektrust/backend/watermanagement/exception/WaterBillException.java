package in.vaidicjoshi.geektrust.backend.watermanagement.exception;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class WaterBillException extends Throwable {
  private static final long serialVersionUID = -195628261663783819L;
  public static final String INVALID_COMMAND = "INVALID_COMMAND";

  /** Constructs a WaterBillException with no detail message. */
  public WaterBillException() {
    super();
  }

  /**
   * Constructs a WaterBillException with the specified detail message. A detail message is a String
   * that describes this particular exception.
   *
   * @param message
   */
  public WaterBillException(String message) {
    super(message);
  }
}
