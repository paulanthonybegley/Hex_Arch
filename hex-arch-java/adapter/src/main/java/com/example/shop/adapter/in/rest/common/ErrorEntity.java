package com.example.shop.adapter.in.rest.common;

/**
 * An error entity with a status and message returned via REST API in case of an error.
 *
 * @author Paul Anthony Begley
 */
public record ErrorEntity(int httpStatus, String errorMessage) {}

