package org.example.command.user.delete;

import org.example.IRequest;

public record DeleteUserCommand(Long userId) implements IRequest {
}
