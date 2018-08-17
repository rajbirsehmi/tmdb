package com.creative.tmdb.builder;

import com.creative.tmdb.pojomapping.Image;

public class ImageBuilder {
    public static class Builder {
        private Image image;

        public Builder() {
            image = new Image();
        }

        public Image build() {
            return image;
        }

        public Builder setAspectRatio(float aspectRatio) {
            image.setAspectRatio(aspectRatio);
            return this;
        }

        public Builder setImageUrl(String imageUrl) {
            image.setImageUrl(imageUrl);
            return this;
        }

        public Builder setImageHeight(int imageHeight) {
            image.setImageHeight(imageHeight);
            return this;
        }

        public Builder setImageWidth(int imageWidth) {
            image.setImageWidth(imageWidth);
            return this;
        }

        public Builder setVoteAverage(float voteAverage) {
            image.setVoteAverage(voteAverage);
            return this;
        }

        public Builder setVoteCount(int voteCount) {
            image.setVoteCount(voteCount);
            return this;
        }
    }
}
