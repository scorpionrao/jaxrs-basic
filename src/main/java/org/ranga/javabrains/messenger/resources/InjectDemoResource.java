package org.ranga.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectDemo")
public class InjectDemoResource {

    @GET
    @Path("/annotations")
    public String demo(@MatrixParam("param") String maxtrixParamValue,
                       @HeaderParam("authSessionId") String authSessionId,
                       @CookieParam("userId") String userId) {
        return "Matrix param: " + maxtrixParamValue + ", AuthSessionId: " + authSessionId + ", userId: " + userId;
    }

    @GET
    @Path("/context")
    public String demo(@Context UriInfo uriInfo) {
        String path = uriInfo.getAbsolutePath().toString();
        return "UriInfo path: " + path;
    }
}
