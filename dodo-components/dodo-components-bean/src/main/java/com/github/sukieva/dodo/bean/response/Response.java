package com.github.sukieva.dodo.bean.response;

import com.github.sukieva.dodo.bean.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * Response to Client
 *
 * @author SukiEva
 * @since 2024-05-05
 */
@Getter
@Setter
public abstract class Response extends DTO {
    private RespStatus status;

    private Collection<RespError> errors;
}