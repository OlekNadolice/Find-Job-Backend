package org.example.command.user.delete;

import org.example.IRequest;

import java.util.UUID;

public record DeleteUserCommand(UUID userId) implements IRequest {
}
