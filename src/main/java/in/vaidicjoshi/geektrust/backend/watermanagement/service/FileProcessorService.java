package in.vaidicjoshi.geektrust.backend.watermanagement.service;

import in.vaidicjoshi.geektrust.backend.watermanagement.exception.WaterBillException;
import in.vaidicjoshi.geektrust.backend.watermanagement.model.Command;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
@RequiredArgsConstructor
public class FileProcessorService {
  @NonNull private String filePath;

  public List<Command> getCommandsFromFile() throws WaterBillException {
    try (Stream<String> lines = Files.lines(Paths.get(this.filePath))) {
      return lines
          .filter(line -> !isEmptyOrComment(line))
          .map(Command::from)
          .collect(Collectors.toList());
    } catch (IOException e) {
      throw new WaterBillException("Some error occurred while processing input file  " + filePath);
    }
  }

  private boolean isEmptyOrComment(String line) {
    return Strings.isEmpty(line) || line.trim().isEmpty() || line.trim().startsWith("#");
  }
}
