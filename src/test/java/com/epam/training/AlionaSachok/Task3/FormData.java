package com.epam.training.AlionaSachok.Task3;

import java.util.Objects;

public class FormData {

    private String productName;
    private String numberOfInstances;
    private String operatingSystemSoftware;
    private String provisioningModel;
    private String machineFamily;
    private String series;
    private String machineType;
    private String gpuType;
    private String numberOfGPUs;
    private String localSSD;
    private String region;

    public FormData() {
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public String getOperatingSystemSoftware() {
        return operatingSystemSoftware;
    }

    public void setOperatingSystemSoftware(String operatingSystemSoftware) {
        this.operatingSystemSoftware = operatingSystemSoftware;
    }

    public String getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(String provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public String getMachineFamily() {
        return machineFamily;
    }

    public void setMachineFamily(String machineFamily) {
        this.machineFamily = machineFamily;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "FormData{" +
                "numberOfInstances='" + numberOfInstances + '\'' +
                ", operatingSystemSoftware='" + operatingSystemSoftware + '\'' +
                ", provisioningModel='" + provisioningModel + '\'' +
                ", machineFamily='" + machineFamily + '\'' +
                ", series='" + series + '\'' +
                ", machineType='" + machineType + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPUs='" + numberOfGPUs + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", region='" + region + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormData formData = (FormData) o;
        return Objects.equals(numberOfInstances, formData.numberOfInstances) &&
                Objects.equals(operatingSystemSoftware, formData.operatingSystemSoftware) &&
                Objects.equals(provisioningModel, formData.provisioningModel) &&
                Objects.equals(machineFamily, formData.machineFamily) &&
                Objects.equals(series, formData.series) &&
                Objects.equals(machineType, formData.machineType) &&
                Objects.equals(gpuType, formData.gpuType) &&
                Objects.equals(numberOfGPUs, formData.numberOfGPUs) &&
                Objects.equals(localSSD, formData.localSSD) &&
                Objects.equals(region, formData.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystemSoftware, provisioningModel, machineFamily,
                series, machineType, gpuType, numberOfGPUs, localSSD, region);
    }
}

