package com.java.stockmarket.stock.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stock {

	public Stock(Integer quarter, String stock, Date date, String open, String high, String low, String close,
			Long volume, Double percentChangePrice, Double percentChangeVolumeOverLastWk, Long previousWeeksVolume,
			String nextWeeksOpen, String nextWeeksClose, Double percentChangeNextWeeksPrice, Integer daysToNextDividend,
			Double percentReturnNextDividend) {
		super();
		this.quarter = quarter;
		this.stock = stock;
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.percentChangePrice = percentChangePrice;
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
		this.previousWeeksVolume = previousWeeksVolume;
		this.nextWeeksOpen = nextWeeksOpen;
		this.nextWeeksClose = nextWeeksClose;
		this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
		this.daysToNextDividend = daysToNextDividend;
		this.percentReturnNextDividend = percentReturnNextDividend;
	}

	@JsonProperty("quarter")
	private Integer quarter;
	
	@JsonProperty("stock")
	private String stock;
	
	@JsonProperty("date")
	private Date date;

	@JsonProperty("open")
	private String open;
	
	@JsonProperty("high")
	private String high;
	
	@JsonProperty("low")
	private String low;
	
	@JsonProperty("close")
	private String close;
	
	@JsonProperty("volume")
	private Long volume;
	
	@JsonProperty("percent_change_price")
	private Double percentChangePrice;
	
	@JsonProperty("percent_change_volume_over_last_wk")
	private Double percentChangeVolumeOverLastWk;
	
	@JsonProperty("previous_weeks_volume")
	private Long previousWeeksVolume;
	
	@JsonProperty("next_weeks_open")
	private String nextWeeksOpen;
	
	@JsonProperty("next_weeks_close")
	private String nextWeeksClose;
	
	@JsonProperty("percent_change_next_weeks_price")
	private Double percentChangeNextWeeksPrice;
	
	@JsonProperty("days_to_next_dividend")
	private Integer daysToNextDividend;
	
	@JsonProperty("percent_return_next_dividend")
	private Double percentReturnNextDividend;

	public Integer getQuarter() {
		return quarter;
	}

	public void setQuarter(Integer quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public Double getPercentChangePrice() {
		return percentChangePrice;
	}

	public void setPercentChangePrice(Double percentChangePrice) {
		this.percentChangePrice = percentChangePrice;
	}

	public Double getPercentChangeVolumeOverLastWk() {
		return percentChangeVolumeOverLastWk;
	}

	public void setPercentChangeVolumeOverLastWk(Double percentChangeVolumeOverLastWk) {
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
	}

	public Long getPreviousWeeksVolume() {
		return previousWeeksVolume;
	}

	public void setPreviousWeeksVolume(Long previousWeeksVolume) {
		this.previousWeeksVolume = previousWeeksVolume;
	}

	public String getNextWeeksOpen() {
		return nextWeeksOpen;
	}

	public void setNextWeeksOpen(String nextWeeksOpen) {
		this.nextWeeksOpen = nextWeeksOpen;
	}

	public String getNextWeeksClose() {
		return nextWeeksClose;
	}

	public void setNextWeeksClose(String nextWeeksClose) {
		this.nextWeeksClose = nextWeeksClose;
	}

	public Double getPercentChangeNextWeeksPrice() {
		return percentChangeNextWeeksPrice;
	}

	public void setPercentChangeNextWeeksPrice(Double percentChangeNextWeeksPrice) {
		this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
	}

	public Integer getDaysToNextDividend() {
		return daysToNextDividend;
	}

	public void setDaysToNextDividend(Integer daysToNextDividend) {
		this.daysToNextDividend = daysToNextDividend;
	}

	public Double getPercentReturnNextDividend() {
		return percentReturnNextDividend;
	}

	public void setPercentReturnNextDividend(Double percentReturnNextDividend) {
		this.percentReturnNextDividend = percentReturnNextDividend;
	}

	@Override
	public String toString() {
		return "Stock [quarter=" + quarter + ", stock=" + stock + ", date=" + date + ", open=" + open + ", high=" + high
				+ ", low=" + low + ", close=" + close + ", volume=" + volume + ", percentChangePrice="
				+ percentChangePrice + ", percentChangeVolumeOverLastWk=" + percentChangeVolumeOverLastWk
				+ ", previousWeeksVolume=" + previousWeeksVolume + ", nextWeeksOpen=" + nextWeeksOpen
				+ ", nextWeeksClose=" + nextWeeksClose + ", percentChangeNextWeeksPrice=" + percentChangeNextWeeksPrice
				+ ", daysToNextDividend=" + daysToNextDividend + ", percentReturnNextDividend="
				+ percentReturnNextDividend + "]";
	}
	
}
