package org.example.query.company.getCompany;

import org.example.IRequest;

public record GetCompanyQuery(Long companyId) implements IRequest {
}
