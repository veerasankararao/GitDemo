package Baseclass;




	import java.io.File;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebDriverException;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.ITestResult;

	public class BaseClass {
		public static WebDriver driver;

		
			//BROWSERLUNCH
		public static WebDriver getBrowser(String browserName) throws Exception {		
			
				try {
					if (browserName.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver1.exe");
					
					driver = new ChromeDriver();
					}
					else if (browserName.equalsIgnoreCase("firefox")) {
						System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\gekhodriver.exe");
						 driver = new FirefoxDriver();
					}else if (browserName.equalsIgnoreCase("ie")) {
						System.setProperty("webdriver.IEDriverServer.driver", System.getProperty("user.dir")+"\\Drivers\\IEDriverServer.exe");
						 driver = new InternetExplorerDriver();	
					}else {
						throw new Exception("choose yourcurrent browser");
					}
						
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					return driver;
					
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception();	
				}
		}
		
		
			//GETURL
		
		public static void geturl(String url) throws Exception {
			try {
				driver.get(url);
			} catch (Exception e) {

				e.printStackTrace();
				throw new Exception();
			}
		}
		
				//WAIT
		
		public static void waitforElementVisibulity(WebElement element) throws Exception {
			try {
				WebDriverWait wb= new WebDriverWait(driver, 60);
				wb.until(ExpectedConditions.visibilityOf(element));
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception();
			}
		}
		
			//IS DISPLAYED
		
	public static boolean IsDisplayed(WebElement element) throws Exception {
		try {
			boolean displayed=element.isDisplayed();
			return displayed;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
		
			//IS ENABLED

		public static boolean IsEnabled(WebElement element) throws Exception {
			try {
				boolean enable = element.isEnabled();
				return enable;
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception();
			}
		}
		
				//IS SELECTED
		
		public static boolean IsSelected(WebElement element) throws Exception {
			try {
				boolean selected = element.isSelected();
				return selected;
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception();
			}
		}
		
			//SENDKEYS
		
		public static void sendkeys(WebElement element,String values) throws Exception {
			try {
				waitforElementVisibulity(element);
				if (IsDisplayed(element)&&IsEnabled(element)) {
					element.clear();
					element.sendKeys(values);	
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception();
			
			}
		}
		
			// MOUSEHOVER
		
		public static void mouseHover(WebElement element) throws Exception {
			try {
				waitforElementVisibulity(element);
				Actions ac= new Actions(driver);
				ac.moveToElement(element).build().perform();
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception();
			}
		}
		
			//CLICK
			
	public static void click(WebElement element) throws Exception {
		try {
			waitforElementVisibulity(element);
			if (IsDisplayed(element)) {
				element.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
			//SELECT DROPDOWN
		public static void selectDropDown(WebElement element,String option,String value) throws Exception {
				try {
					//waitforElementVisibulity(element);
					Select sc= new Select(element);
					
					
					if (option.equalsIgnoreCase("value")) {
						sc.selectByValue(value);
					} else if (option.equalsIgnoreCase("visibletext")) {
						sc.selectByVisibleText(value);
					} else if (option.equalsIgnoreCase("index")) {
						sc.selectByIndex(Integer.parseInt(value));
					}
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception();
				}
		}
				
				//SCROLL THE ELEMENT
				
		public static void scrollTo(WebElement element) throws Exception {
			try {
				waitforElementVisibulity(element);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(();",element);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception();
			}
		}
		
			//SCROLL USING PIXELS
		
			public static void scrollByUsingPixels(int width,int height) throws Exception {
				try {
					JavascriptExecutor js= (JavascriptExecutor) driver;
					js.executeScript("windows.scrollBy("+width+","+height+")");
				} catch (Exception e) {
					e.printStackTrace();
					throw new Exception();
				}
			}
		
				//SCROLL DOWN OF THE PAGE
			
		public static void scrollToBottomOfThePage() throws Exception {
			try {
				JavascriptExecutor js= (JavascriptExecutor) driver;
				js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception();
			}
		}	
		
				//DRAG AND DROP
		
		public static void dragAndDrop(WebElement src,WebElement tar) throws Exception {
			try {
				waitforElementVisibulity(src);
				Actions ac= new Actions(driver);
				ac.dragAndDrop(src, tar).build().perform();
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception();
			}
		}
		
				//DOUBLE CLICK
		
	public static void doubleClick(WebElement element) throws Exception {
		try {
			waitforElementVisibulity(element);
			Actions ac= new Actions(driver);
			ac.doubleClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
		
			//RIGHT CLICK

	public static void rightClick(WebElement element) throws Exception {
		try {
			waitforElementVisibulity(element);
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

			//ALERT ACCEPT

	public static void alertAccept() throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();

		}
	}

			//ALERT DISMISS

	public static void alertDismiss() throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

			//ALERT SENDKEYS

	public static void alertSendKeys(String value) throws Exception {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(value);
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
			//SWITCH TO DEFAULTCONTENT
	public static void DefaultContent() throws Exception {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
				
			//GET TEXT 

	public static String getText(WebElement element) throws Exception {
		try {
			waitforElementVisibulity(element);
			String text = element.getText();
			return text;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
			 
		}
	}

			//GET ATTRIBUTE

	public static String getAttribute(WebElement element, String attKey) throws Exception {
		try {
			waitforElementVisibulity(element);
			String attribute = element.getAttribute(attKey);
			return attribute;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}  



			//FRAME

	public static void Frame(WebElement element) throws Exception {
		try {
			driver.switchTo().frame(element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

			//SCREENSHOT

	public static void screenShot(String filename) throws Exception {
		try {
			File des = new File(System.getProperty("user.dir") + "/library/screenshot/" + filename + ".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotAs,des);
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

			//SWITCH TO WINDOW HANDLING

	public static void WindowHandle(String windowTitle) throws Exception {
		try {
			Set<String> pId = driver.getWindowHandles();
			for (String x : pId) {
				driver.switchTo().window(x);
				String title = driver.getTitle();
				if (title.equals(windowTitle)) {
					driver.switchTo().window(x);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

			//GET TITLE

	public static String getTitle() throws Exception {
		try {
			String title = driver.getTitle();
			return title;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

			//CURRENTURL

	public static String getCurrentUrl() throws Exception {
		try {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

			//NAVIGATE URL

	public static void navigateToUrl(String url) throws Exception {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

			//NAVIGATE COMMANDS

	public void navigateCommands(String option) throws Exception {
		try {
			if (option.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			} else if (option.equalsIgnoreCase("backward")) {
				driver.navigate().back();
			} else if (option.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

			//WEBTABLE

	public static List<String> WebTable(String header) throws Exception {
		try {
			List<String> li = new ArrayList<String>();
			WebElement table = driver.findElement(By.tagName("//table"));
			List<WebElement> trow = table.findElements(By.tagName("tr"));
			for (int i = 0; i < trow.size(); i++) {
				List<WebElement> thead = trow.get(i).findElements(By.tagName("th"));
				for (int j = 0; j < thead.size(); j++) {
					String text = thead.get(j).getText();
					if (text.equals(header)) {
						List<WebElement> tdata = trow.get(i).findElements(By.tagName("td"));
						for (int k = 0; k < tdata.size(); k++) {
							String tdataContent = tdata.get(k).getText();
							li.add(tdataContent);
						}
					}
				}
			}
			return li;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}

	}

			//GETTING DATA GROM JDBC

	public static void DataBaseUsingJDBC(String url, String userName, String passWord, String query,
			String columnName) throws Exception {
		try {
			List<String> li = new ArrayList<String>();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, userName, passWord);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String data = rs.getString(columnName);
				li.add(data);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
			//CLOSE

	public static void Close() throws Exception {
		try {
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}
			//QUIT

	public static void Quit() throws Exception {
		try {
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	  }







	}



