package com.podufalyy.mapping;

public abstract class AbstractMapper<T, DTO> {
    public abstract DTO mapObjectToDto(T object);
}