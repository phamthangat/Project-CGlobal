package com.project.CGlobal.Domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse {
    private Object content;
    private int pageNo;
    private int pageSize;
    private int totalPages;
}
