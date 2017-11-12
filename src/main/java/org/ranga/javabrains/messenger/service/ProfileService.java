package org.ranga.javabrains.messenger.service;

import org.ranga.javabrains.messenger.database.DatabaseClass;
import org.ranga.javabrains.messenger.model.Profile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileService {

    Map<String, Profile> profiles = DatabaseClass.getProfiles();

    public ProfileService() {
        profiles.put("ranga", new Profile(1L, "ranga", "Ranga", "Gonu"));
    }

    public List<Profile> getAllProfiles() {
        return new ArrayList<>(profiles.values());
    }

    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile) {
        profile.setId(profiles.size() + 1);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if(profile.getProfileName().isEmpty()) {
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profiles.get(profile.getId());
    }

    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }
}
