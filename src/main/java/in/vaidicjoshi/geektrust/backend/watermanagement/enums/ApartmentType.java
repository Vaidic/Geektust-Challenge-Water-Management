package in.vaidicjoshi.geektrust.backend.watermanagement.enums;

import in.vaidicjoshi.geektrust.backend.watermanagement.exception.WaterBillException;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Vaidic Joshi
 * @date 20/11/21
 */
@RequiredArgsConstructor
@Getter
public enum ApartmentType {
  TW0_BEDROOM_APARTMENT(2, 3),
  THREE_BEDROOM_APARTMENT(3, 5);
  @NonNull private Integer numberOfRooms;
  @NonNull private Integer numberOfPeople;

  private static Map<Integer, ApartmentType> lookup = new HashMap<>();

  static {
    lookup =
        Arrays.stream(ApartmentType.values())
            .collect(Collectors.toMap(ApartmentType::getNumberOfRooms, Function.identity()));
  }

  public static ApartmentType fromNumberOfRooms(int rooms) throws WaterBillException {
    return Optional.ofNullable(lookup.get(rooms))
        .orElseThrow(() -> new WaterBillException(WaterBillException.INVALID_COMMAND));
  }
}
