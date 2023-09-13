package org.example.command.company.delete;

import org.example.IRequest;

import java.util.UUID;

public record DeleteCompanyCommand(UUID companyId) implements IRequest {
}
