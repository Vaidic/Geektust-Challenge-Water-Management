package in.vaidicjoshi.geektrust.backend.watermanagement;

import in.vaidicjoshi.geektrust.backend.watermanagement.exception.WaterBillException;
import in.vaidicjoshi.geektrust.backend.watermanagement.model.Command;
import in.vaidicjoshi.geektrust.backend.watermanagement.service.FileProcessorService;

import java.util.List;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
public class WaterBillApp {

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
      // execute each command
      //      List<String> outputs =
      //          commands.stream()
      //              .map(
      //                  command ->
      //                      command
      //                          .getOperation()
      //                          .getOperationService()
      //                          .get()
      //                          .processOperation(command.getArguments(), mySpace))
      //              .collect(Collectors.toList());
      // print output
      //      outputs.forEach(System.out::println);
    } catch (WaterBillException | Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
