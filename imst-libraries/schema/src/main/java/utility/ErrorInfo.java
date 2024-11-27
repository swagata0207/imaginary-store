package utility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class ErrorInfo {
    private String errorCode;
    private String errorMessage;
    private LocalDateTime timeStamp;
}