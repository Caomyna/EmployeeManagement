USE [master]
GO
CREATE DATABASE [EmployeeManagement]
GO
ALTER DATABASE [EmployeeManagement] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [EmployeeManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [EmployeeManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [EmployeeManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [EmployeeManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [EmployeeManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [EmployeeManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [EmployeeManagement] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [EmployeeManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [EmployeeManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [EmployeeManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [EmployeeManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [EmployeeManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [EmployeeManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [EmployeeManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [EmployeeManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [EmployeeManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [EmployeeManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [EmployeeManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [EmployeeManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [EmployeeManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [EmployeeManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [EmployeeManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [EmployeeManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [EmployeeManagement] SET RECOVERY FULL 
GO
ALTER DATABASE [EmployeeManagement] SET  MULTI_USER 
GO
ALTER DATABASE [EmployeeManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [EmployeeManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [EmployeeManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [EmployeeManagement] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [EmployeeManagement] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [EmployeeManagement] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'EmployeeManagement', N'ON'
GO
ALTER DATABASE [EmployeeManagement] SET QUERY_STORE = OFF
GO
USE [EmployeeManagement]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Employee](
	[EmployeeID] [char](15) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[DOB] [char](10) NOT NULL,
	[Gender] [nvarchar](10) NOT NULL,
	[Phone] [char](11) NULL,
	[Email] [char](30) NULL,
	[Address] [nvarchar](50) NULL,
	[Position] [nvarchar](30) NOT NULL,
	[Salary] [float] NOT NULL,
 CONSTRAINT [PK_Employee] PRIMARY KEY CLUSTERED 
(
	[EmployeeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Login]    Script Date: 8/17/2022 10:59:13 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Login](
	[Username] [char](15) NOT NULL,
	[Password] [char](15) NOT NULL,
	[Access_right] [nchar](10) NULL,
 CONSTRAINT [PK_Login] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Employee] ([EmployeeID], [Name], [DOB], [Gender], [Phone], [Email], [Address], [Position], [Salary]) VALUES (N'E01', N'Mino', N'1999-10-05', N'nữ', N'0987654321 ', N'mino@gmail.com', N'quảng nam', N'nhân viên bán hàng', 4000000)
INSERT [dbo].[Employee] ([EmployeeID], [Name], [DOB], [Gender], [Phone], [Email], [Address], [Position], [Salary]) VALUES (N'E02', N'My', N'2000-11-14', N'nữ', N'0983654128 ', N'my@gmail.com', N'huế', N'kế toán', 5000000)
INSERT [dbo].[Employee] ([EmployeeID], [Name], [DOB], [Gender], [Phone], [Email], [Address], [Position], [Salary]) VALUES (N'E04', N'Mei', N'2003-03-02', N'nữ', N'0981166253 ', N'mei@gmail.com', N'đà nẵng', N'nhân viên bán hàng', 4000000)
INSERT [dbo].[Employee] ([EmployeeID], [Name], [DOB], [Gender], [Phone], [Email], [Address], [Position], [Salary]) VALUES (N'E05', N'Tom', N'1998-05-13', N'nam', N'0987654321 ', N'tom@gmail.com', N'hà nội', N'nhân viên bán hàng', 4000000)
INSERT [dbo].[Employee] ([EmployeeID], [Name], [DOB], [Gender], [Phone], [Email], [Address], [Position], [Salary]) VALUES (N'E06', N'Kao', N'2002-12-06', N'nam', N'0123698523 ', N'nano@gmail.com', N'tp hcm', N'kế toán', 5000000)
INSERT [dbo].[Employee] ([EmployeeID], [Name], [DOB], [Gender], [Phone], [Email], [Address], [Position], [Salary]) VALUES (N'E08', N'Jun', N'1995-01-12', N'nữ', N'0987654321 ', N'jun@gmail.com', N'huế', N'quản lý', 5000000)
INSERT [dbo].[Employee] ([EmployeeID], [Name], [DOB], [Gender], [Phone], [Email], [Address], [Position], [Salary]) VALUES (N'E09', N'No', N'2003-01-01', N'nam', N'0123456788 ', N'no@gmail.com', N'quảng nam', N'bảo vệ', 3000000)
INSERT [dbo].[Employee] ([EmployeeID], [Name], [DOB], [Gender], [Phone], [Email], [Address], [Position], [Salary]) VALUES (N'E10', N'Joy', N'1999-01-01', N'nam', N'0987654321 ', N'joy@gmail.com', N'quảng nam', N'kế toán', 5000000)
GO
INSERT [dbo].[Login] ([Username], [Password], [Access_right]) VALUES (N'admin', N'admin', N'admin     ')
INSERT [dbo].[Login] ([Username], [Password], [Access_right]) VALUES (N'na', N'1111', N'member    ')
GO
USE [master]
GO
ALTER DATABASE [EmployeeManagement] SET  READ_WRITE 
GO
