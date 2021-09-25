package codegym.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailConfiguration {
    private String language;
    private int pageSize;
    private boolean isEnableSpamFilter;
    private String signature;
}
