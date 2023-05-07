package com.dashuju.orders.config;
 /**
 * @description 支付宝配置参数
 */
 public class AlipayConfig {
  //商户appid
  public static String APPID = "2021000122660433";
  // 私钥 pkcs8格式的
  public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCPTj6T6Ablyr/Q6RoqySJfmUvKdzdM6p8ocZhHMvRkiKcI0KAyIyv6uOsiyTQYlqrI+ftCH6f8l3O81I+kO2pYpP0fSPeM5D7nbTGpdp8nAcv+qxzq/8lJPaQ/vf4OqWm4aK0wljJT2gdA2hPASSzUO6Dkm5RLOESUdsAp+RWShxrBJnI6c1NXL2nSv9IcucKHf4P2auwVx5qekymSslN/hxpVNpC2JvRM3DTSApc0k85A7eWtef3r9s+XKFUnCuIC80OL8xl4fFSWWg3siUU6oqaD8IbUB+qi8b90VAADcdH84oewEOPLHFRH6G4mmzlm5VxgMN3yeR8s2+4ey4I/AgMBAAECggEAAeeRT1frF4y9ReKDNYRcz5Zy+mrhMkV//gKcen3D374tMiHLrz7ma7ufbGPuLFF8TZV88GEJU4MTx7OvgQhFHo56yrqmh5nU+DBsU4s/DD6q3mSZysnBfBa0oyA8SyeXPxstChNE8fZY2FTNpGWUkfGE7uTecK17w9lcLnKgBcV+yJMn31DKPUxK35NpnffheLCcewbY/mXDYsR+zm31EBCHoWJGimb7UAbzVFl6nnHxC4+4Ntwg4w17+MaaFggVI8DmpgNTRrG3mWMxTAHx1035KRyuR3ViUc7MPooZE8oVNvU+YF6VfLE75Lh6Nh0gQAmtRuWOmlUFe/FeTD/b4QKBgQDT00LIpnQFfRQO9c54XqBLz+lOh0AN3mPkhxYx4Po3f45g/SdkfQFg9pOvrF35TNhAwSl4CEJMvkKriDGPHMuVr2geZJ5NE+1tR8BoVdAPmqEu3e84PLzx9a/bnwcUibLaLe4he28el7hFuspiLJP6Skvm6SBSvak4Cpem8YkZ8QKBgQCtMOt3eVmqtAkU8zI/xCAYM+N1UfkwvARAqeSNBm+pXdmonb6phpY6knViYHt6XSJHZkQNqKTPGsi1LRGPesRkLn+QdTn3l7OOg5DsEc2Ius57vPojWDM6wFPNsMEhAE/d7pATb20zobDj8mi4n/27+jubgWaDmNqJretx6CSvLwKBgBfq+td9NAyKmwE1cCLXTHJC/60GSI1IVy8usargJGCv3nvFGfWWx9kS/ooPhGzp6GEnbm9HP3U65nxH3JC0R6iXLcKAyf8aCO0V9PvS9LNOWnTYSnKnKQ6JF1pNEpeXFMLd/M17CokByKTW+pMrRWo1iWyBVk0BbWIOkCEhlMGBAoGAYeZDVFfeXeZDM/p9Lxp4YfYC37Ckwe2mIb9nmGhI+l44yV3SBxYzGYzsmd2cLwEyfVXLpkTsVL35MqD1SjvFhDPcnBYH3HN+ZlLsuuUdX+rpCX07kHstCkrplF4T7cm1W+icvL/B5OvDiDbhB2w5C+dZhn/RKRZggm8zpkHparUCgYEAx0A4ptXsSlL3a6SeCILEU1DvLmBJLU0rjKDDcbhbx3pR6FciNTmZirmznXQEDJbjHtPVQ1iRxVJrTKmJsiBkpRYlD45oA7x5P5DIiGNFU13pZmEqM136Hyfx9Lfvr0bRM1rOfY2gnr1O74bPZbI7yQeyrTLCenxXNdipqORBKVA=";
  // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
  public static String notify_url = "http://u6ar42.natappfree.cc/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
  // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
  public static String return_url = "http://u6ar42.natappfree.cc/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
  // 请求网关地址
  public static String URL1 = "https://openapi.alipaydev.com/gateway.do";
  public static String URL = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";
  // 编码
  public static String CHARSET = "UTF-8";
  // 返回格式
  public static String FORMAT = "json";
  // 支付宝公钥
  public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAomc2Y3EjPB55AeprwLjCrL1UMqjoTlxrKrx4pwpqgy1FeLUlqwCDGsSW2/kGkauy3SwWAEdLQX0YQeuRztTRNThESyOLXEHF81/2lMV3uq9LSM1Cd9qLebumarxBy4T+TrRWiz831ZGjQVR73Yrcb471f7lJXua9aKolRbMIYK8o2qXwkdJV9hOnz724Xpyb7UV67CIbIHp5ZqjOOYsCOZCEW+/eXr5tv5OonX2jUGjxpkMIuaxWhEpY6ktwcb71DhMnfAN2aDgHgHEI/ot8fdeF4TBl6u9sgh199c8nN6NfnIZhQ7lHu/XuEoph3S61IK6oM+VxBGgWhRXPUMmZfQIDAQAB";
  // 日志记录目录
  public static String log_path = "/log";
  // RSA2
  public static String SIGNTYPE = "RSA2";
 }
