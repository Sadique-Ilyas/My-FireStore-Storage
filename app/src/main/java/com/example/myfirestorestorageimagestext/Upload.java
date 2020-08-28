package com.example.myfirestorestorageimagestext;

import com.google.firebase.firestore.Exclude;

public class Upload {
    private String Name, ImageUrl, Key;

    public Upload() {
    }

    public Upload(String name, String imageUrl) {
        Name = name;
        ImageUrl = imageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    @Exclude
    public String getKey() {
        return Key;
    }

    @Exclude
    public void setKey(String key) {
        Key = key;
    }
}

