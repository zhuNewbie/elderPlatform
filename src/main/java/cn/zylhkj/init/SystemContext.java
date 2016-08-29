package cn.zylhkj.init;

import org.springframework.context.ApplicationContext;

public class SystemContext
{
  private static ApplicationContext applicationContext;
  
  public static ApplicationContext getApplicationContext()
  {
    return applicationContext;
  }
  
  public static void setApplicationContext(ApplicationContext applicationContext)
  {
    SystemContext.applicationContext = applicationContext;
  }
}