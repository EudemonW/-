package com.jinhang.VO;

import com.jinhang.DTO.UserDTO;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ProjInfos {
    private ProjBasic projBasic;
    private List<String> userIds;
}
