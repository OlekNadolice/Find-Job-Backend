package org.example.query.user.getUser;

import org.example.IRequestHandler;
import org.example.repositories.User.UserQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserQueryHandler implements IRequestHandler<GetUserQuery> {

    private final UserQueryRepository userQueryRepository;


    @Autowired
    public GetUserQueryHandler(UserQueryRepository userQueryRepository) {
        this.userQueryRepository = userQueryRepository;
    }

    @Override
    public Object execute(GetUserQuery query) {
        return null;
    }


    @Override
    public boolean supportsOperation(Object query) {
        return GetUserQuery.class.equals(query);
    }
}
