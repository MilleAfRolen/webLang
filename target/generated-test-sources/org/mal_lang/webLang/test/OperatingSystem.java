package org.mal_lang.webLang.test;

import core.Asset;
import java.lang.Override;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class OperatingSystem extends Asset {
  public Set<WebServer> webserver = new HashSet<>();

  public OperatingSystem(String name) {
    super(name);
    assetClassName = "OperatingSystem";
  }

  public OperatingSystem() {
    this("Anonymous");
  }

  public void addWebserver(WebServer webserver) {
    this.webserver.add(webserver);
    webserver.os = this;
  }

  @Override
  public String getAssociatedAssetClassName(String field) {
    if (field.equals("webserver")) {
      return WebServer.class.getName();
    }
    return "";
  }

  @Override
  public Set<Asset> getAssociatedAssets(String field) {
    Set<Asset> assets = new HashSet<>();
    if (field.equals("webserver")) {
      assets.addAll(webserver);
    }
    return assets;
  }

  @Override
  public Set<Asset> getAllAssociatedAssets() {
    Set<Asset> assets = new HashSet<>();
    assets.addAll(webserver);
    return assets;
  }
}
