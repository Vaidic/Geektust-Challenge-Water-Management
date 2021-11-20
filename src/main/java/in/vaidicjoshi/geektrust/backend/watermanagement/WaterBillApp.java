package in.vaidicjoshi.geektrust.backend.watermanagement;

import in.vaidicjoshi.geektrust.backend.watermanagement.exception.WaterBillException;
import in.vaidicjoshi.geektrust.backend.watermanagement.model.Command;
import in.vaidicjoshi.geektrust.backend.watermanagement.model.GeekHeightsCommunity;
import in.vaidicjoshi.geektrust.backend.watermanagement.service.FileProcessorService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class WaterBillApp {

  public static final Integer ALLOCATED_WATER_PER_PERSON = 10;
  public static final Integer BILLABLE_DAYS_IN_MONTH = 30;

  public static void main(String[] args) {
    // Try to read input file and generate bill
    try {
      if (args.length != 1) {
        throw new WaterBillException("Input file not supplied. Please provide the input file");
      }
      String filePath = args[0];
      // parse the input file
      FileProcessorService fileReaderService = new FileProcessorService(filePath);
      List<Command> commands = fileReaderService.getCommandsFromFile();
      GeekHeightsCommunity geekHeightsCommunity =
          new GeekHeightsCommunity(ALLOCATED_WATER_PER_PERSON, BILLABLE_DAYS_IN_MONTH);
      // execute each command
      List<String> outputs =
          commands.stream()
              .map(
                  command ->
                      command
                          .getOperator()
                          .getOperationService()
                          .get()
                          .processOperation(command.getOperands(), geekHeightsCommunity))
              .filter(Objects::nonNull)
              .collect(Collectors.toList());
      //       print output
      outputs.forEach(System.out::println);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
