package org.example.command.company.delete;

import org.example.IRequest;

public record DeleteCompanyCommand(Long companyId) implements IRequest {
}
