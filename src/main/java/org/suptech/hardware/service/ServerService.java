package org.suptech.hardware.service;



import org.suptech.hardware.model.Server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

public interface ServerService {
    Server create(Server server);
    Server ping(String address) throws IOException;
    Server get(Long id);
    Server update(Server server);
    boolean delete(Long id);
    Collection<Server> list(int limit);
}
