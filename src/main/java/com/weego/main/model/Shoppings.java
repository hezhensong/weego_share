package com.weego.main.model;

import java.util.Date;
import java.util.List;

import org.mongojack.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Shoppings {
	@Id
	private String id;

	@JsonProperty("__v")
	private Integer version;

	private String address;

	private Boolean am;

	private List<RestaurantCategory> category;

	@JsonProperty("city_id")
	private String cityId;

	@JsonProperty("city_name")
	private String cityName;

	private List<BasePOIComments> comments;

	@JsonProperty("cover_image")
	private String coverImage;

	@JsonProperty("create_at")
	private Date createAt;

	@JsonProperty("data_invalid")
	private Boolean dataInvalid;

	private Integer duration;

	@JsonProperty("en_info")
	private BasePOIEnInfo enInfo;

	private Boolean ev;

	private List<String> image;

	@JsonProperty("image_url")
	private List<BasePOIImageUrl> imageUrl;

	private String introduce;

	@JsonProperty("is_big")
	private Boolean bigFlag;

	private String latitude;

	private List<RestaurantCategory> lifetag;

	private List<Double> loc;

	@JsonProperty("local_flag")
	private Boolean localFlag;

	private String longitude;

	private String name;

	@JsonProperty("name_en")
	private String nameEn;

	@JsonProperty("open_time")
	private List<BasePOIOpenTime> openTime;

	private Boolean pm;

	@JsonProperty("postal_code")
	private String postalCode;

	@JsonProperty("price_desc")
	private String priceDesc;

	@JsonProperty("price_level")
	private Integer priceLevel;

	private Integer ranking;

	private Integer rating;

	@JsonProperty("rating_env")
	private Integer ratingEnv;

	@JsonProperty("rating_service")
	private Integer ratingService;

	@JsonProperty("rating_trust")
	private Integer ratingTrust;

	@JsonProperty("recommand_flag")
	private String recommandFlag;

	private Integer reviews;

	private Integer score;

	@JsonProperty("show_flag")
	private Boolean showFlag;

	private String tel;

	private String type;

	private String url;

	@JsonProperty("yelp_img_url")
	private String yelpImgUrl;

	private String tips;

	private List<ShoppingBrand> brand;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getAm() {
		return am;
	}

	public void setAm(Boolean am) {
		this.am = am;
	}

	public List<RestaurantCategory> getCategory() {
		return category;
	}

	public void setCategory(List<RestaurantCategory> category) {
		this.category = category;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<BasePOIComments> getComments() {
		return comments;
	}

	public void setComments(List<BasePOIComments> comments) {
		this.comments = comments;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Boolean getDataInvalid() {
		return dataInvalid;
	}

	public void setDataInvalid(Boolean dataInvalid) {
		this.dataInvalid = dataInvalid;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public BasePOIEnInfo getEnInfo() {
		return enInfo;
	}

	public void setEnInfo(BasePOIEnInfo enInfo) {
		this.enInfo = enInfo;
	}

	public Boolean getEv() {
		return ev;
	}

	public void setEv(Boolean ev) {
		this.ev = ev;
	}

	public List<String> getImage() {
		return image;
	}

	public void setImage(List<String> image) {
		this.image = image;
	}

	public List<BasePOIImageUrl> getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(List<BasePOIImageUrl> imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Boolean getBigFlag() {
		return bigFlag;
	}

	public void setBigFlag(Boolean bigFlag) {
		this.bigFlag = bigFlag;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public List<RestaurantCategory> getLifetag() {
		return lifetag;
	}

	public void setLifetag(List<RestaurantCategory> lifetag) {
		this.lifetag = lifetag;
	}

	public List<Double> getLoc() {
		return loc;
	}

	public void setLoc(List<Double> loc) {
		this.loc = loc;
	}

	public Boolean getLocalFlag() {
		return localFlag;
	}

	public void setLocalFlag(Boolean localFlag) {
		this.localFlag = localFlag;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public List<BasePOIOpenTime> getOpenTime() {
		return openTime;
	}

	public void setOpenTime(List<BasePOIOpenTime> openTime) {
		this.openTime = openTime;
	}

	public Boolean getPm() {
		return pm;
	}

	public void setPm(Boolean pm) {
		this.pm = pm;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPriceDesc() {
		return priceDesc;
	}

	public void setPriceDesc(String priceDesc) {
		this.priceDesc = priceDesc;
	}

	public Integer getPriceLevel() {
		return priceLevel;
	}

	public void setPriceLevel(Integer priceLevel) {
		this.priceLevel = priceLevel;
	}

	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getRatingEnv() {
		return ratingEnv;
	}

	public void setRatingEnv(Integer ratingEnv) {
		this.ratingEnv = ratingEnv;
	}

	public Integer getRatingService() {
		return ratingService;
	}

	public void setRatingService(Integer ratingService) {
		this.ratingService = ratingService;
	}

	public Integer getRatingTrust() {
		return ratingTrust;
	}

	public void setRatingTrust(Integer ratingTrust) {
		this.ratingTrust = ratingTrust;
	}

	public String getRecommandFlag() {
		return recommandFlag;
	}

	public void setRecommandFlag(String recommandFlag) {
		this.recommandFlag = recommandFlag;
	}

	public Integer getReviews() {
		return reviews;
	}

	public void setReviews(Integer reviews) {
		this.reviews = reviews;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Boolean getShowFlag() {
		return showFlag;
	}

	public void setShowFlag(Boolean showFlag) {
		this.showFlag = showFlag;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getYelpImgUrl() {
		return yelpImgUrl;
	}

	public void setYelpImgUrl(String yelpImgUrl) {
		this.yelpImgUrl = yelpImgUrl;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public List<ShoppingBrand> getBrand() {
		return brand;
	}

	public void setBrand(List<ShoppingBrand> brand) {
		this.brand = brand;
	}

}
