package com.example.android.news_app;

/**
 * An {@link News} object contains information related to a single news.
 */
public class News {
    /**
     * Title of news
     */
    private String mTitle;

    /**
     * Section of the news
     */
    private String mSectionName;

    /**
     * Type where the news is grouped along into
     */
    private String mType;

    private String mUrl;

    /**
     * Constructs a new {@link News} object.
     *
     * @param title       is the title of the news
     * @param sectionName is the section where the news is grouped
     * @param type        is the type of news
     */
    public News(String title, String sectionName, String type, String url) {
        mTitle = title;
        mSectionName = sectionName;
        mType = type;
        mUrl = url;
    }

    /**
     * Returns the title of the news.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the section of the news.
     */
    public String getSection() {
        return mSectionName;
    }

    /**
     * Returns the type of the news.
     */
    public String getType() {
        return mType;
    }

    /**
     * Returns the website URL to find more information about the news.
     */
    public String getUrl() {
        return mUrl;
    }
}
