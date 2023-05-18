package com.api.server.configs;

import org.mapstruct.MapperConfig;

import static org.mapstruct.ReportingPolicy.IGNORE;

@MapperConfig(unmappedTargetPolicy = IGNORE)
public interface IgnoreUnmappedMapperConfig {
}
