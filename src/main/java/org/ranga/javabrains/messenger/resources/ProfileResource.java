package org.ranga.javabrains.messenger.resources;

import org.ranga.javabrains.messenger.database.DatabaseClass;
import org.ranga.javabrains.messenger.model.Message;
import org.ranga.javabrains.messenger.model.Profile;
import org.ranga.javabrains.messenger.service.MessageService;
import org.ranga.javabrains.messenger.service.ProfileService;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getMessages() {
        return profileService.getAllProfiles();
    }

    @GET
    @Path("/{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return profileService.getProfile(profileName);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }

    @PUT
    @Path("/{profileName}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Profile updateMessage(@PathParam("profileName") String profileName, Profile profile) {
        profile.setProfileName(profileName);
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("/{profileName}")
    public Profile deleteProfile(@PathParam("profileName") String profileName) {
        return profileService.removeProfile(profileName);
    }


}
