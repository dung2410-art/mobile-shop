Create Database PRJ301
Use PRJ301
GO
/*role table*/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create table [dbo].[Role]
(
[id][int] IDENTITY (1,1) NOT NULL,
[name][nvarchar](100),
 CONSTRAINT [PK_dbo.Role] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/*user table*/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create table [dbo].[User]
(
[id][int] IDENTITY (1,1) NOT NULL,
[name][nvarchar](100),
[roleId][int],
[phone][nvarchar](100),
[email][nvarchar](100),
[address][nvarchar](100),
 CONSTRAINT [PK_dbo.User] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/*table category*/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create table [dbo].[Category]
(
[cid] [int] IDENTITY(1,1) NOT NULL,
[cname] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/*table Product*/
CREATE TABLE [dbo].[Product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nvarchar](40) NOT NULL,
	[image] [nvarchar](100) NULL,
	[price] [int]NOT NULL,
	[quantity] [int],
	[description] [nvarchar](200) NOT NULL,
	[brand][nvarchar](100) NOT NULL,
	[size] [nvarchar](50) NOT NULL,
	[model][nvarchar](50) NOT NULL,
	[cateID] [int] NULL,
) ON [PRIMARY] 
GO
/* table order */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[Id] [int]  IDENTITY(1,1) NOT NULL,
	[ProductID] [int] NULL,
	[Amount] [Float] NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/* table order detail */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order_Detail](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NULL,
	[product_id] [int] NULL,
	[product_name] [nvarchar](200) NULL,
	[product_price] [decimal](18, 0) NULL,
	[quantity] [int] NULL,
	[product_image] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO 
/* table Payment */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[order_id] [int] NOT NULL,
	[User_id][int] NOT NULL,
	[Paydate][datetime] NOT NULL,
	[PaymentMethod] [nvarchar](200) NULL,
	[Payee] [nvarchar](200) NULL,
	[Amount] [Float] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO


SET IDENTITY_INSERT [dbo].[Role] ON
INSERT [dbo].[Role] ([id],[name]) VALUES (1, 'Admin')
INSERT [dbo].[Role] ([id],[name]) VALUES (2, 'Customer')

SET IDENTITY_INSERT [dbo].[Role] OFF

SET IDENTITY_INSERT [dbo].[User] ON
INSERT [dbo].[User] ([id],[name],[roleId],[phone],[email],[address]) VALUES (1, 'Dung',1,0985066089,'ntd113663@gmail.com','Hai Phong')
INSERT [dbo].[User] ([id],[name],[roleId],[phone],[email],[address]) VALUES (2, 'Quan',2,0985066088,'naq113663@gmail.com','Hai Phong')
INSERT [dbo].[User] ([id],[name],[roleId],[phone],[email],[address]) VALUES (3, 'Trung',2,0985066087,'tdt113663@gmail.com','Hai Phong')


SET IDENTITY_INSERT [dbo].[User] OFF

SET IDENTITY_INSERT [dbo].[Category] ON

INSERT [dbo].[Category] ([cid],[cname]) VALUES (1, 'Phone')
INSERT [dbo].[Category] ([cid],[cname]) VALUES (2, 'Charging cord')
INSERT [dbo].[Category] ([cid],[cname]) VALUES (3, 'Ear phone')


SET IDENTITY_INSERT [dbo].[Category] OFF

SET IDENTITY_INSERT [dbo].[Product] ON

ALTER TABLE [Product]

INSERT [dbo].[Product] ([id],[name],[image],[price],[quantity],[description],[brand],[size],[model],[cateID]) VALUES (1,'IphoneXS',Null,20000000,100,'Nice','Iphone','6.5inch','2020',1)
INSERT [dbo].[Product] ([id],[name],[image],[price],[quantity],[description],[brand],[size],[model],[cateID]) VALUES (2,'SamSungJ5',Null,7000000,100,'Nice','Samsung','5 inch','2016',1)
INSERT [dbo].[Product] ([id],[name],[image],[price],[quantity],[description],[brand],[size],[model],[cateID]) VALUES (3,'Oppo a95',Null,6500000,100,'Nice','Oppo','6.5inch','2018',1)
INSERT [dbo].[Product] ([id],[name],[image],[price],[quantity],[description],[brand],[size],[model],[cateID]) VALUES (4,'Iphone XS cord',Null,550000,100,'Nice','Iphone cord','30 cm','2020',2)
INSERT [dbo].[Product] ([id],[name],[image],[price],[quantity],[description],[brand],[size],[model],[cateID]) VALUES (5,'AirPod 3',Null,1000000,100,'Nice','Airpod new','3 cm','2020',3)

SET IDENTITY_INSERT [dbo].[Product] OFF


SET IDENTITY_INSERT [dbo].[Order] ON

INSERT [dbo].[Order] ([Id],[ProductID],[Amount]) VALUES (1, 1, 40000000)
INSERT [dbo].[Order] ([Id],[ProductID],[Amount]) VALUES (2, 1, 80000000)
INSERT [dbo].[Order] ([Id],[ProductID],[Amount]) VALUES (3, 5, 2000000)

SET IDENTITY_INSERT [dbo].[Order] OFF

SET IDENTITY_INSERT [dbo].[Order_Detail] ON


INSERT [dbo].[Order_Detail] ([id],[order_id],[product_id],[product_name],[product_price],[quantity],[product_image]) VALUES (1, 1, 1,'IphoneXS',20000000,2,NULL)
INSERT [dbo].[Order_Detail] ([id],[order_id],[product_id],[product_name],[product_price],[quantity],[product_image]) VALUES (2, 2, 1,'IphoneXS',20000000,4,NULL)
INSERT [dbo].[Order_Detail] ([id],[order_id],[product_id],[product_name],[product_price],[quantity],[product_image]) VALUES (3, 3, 5,'AirPod 3',1000000,2,NULL)

SET IDENTITY_INSERT [dbo].[Order_Detail] OFF

SET IDENTITY_INSERT [dbo].[Payment] ON

INSERT [dbo].[Payment] ([id],[order_id],[User_id],[Paydate],[PaymentMethod],[Payee],[Amount]) VALUES (1, 1, 2,'2022/04/14','paypal','paypal',40000000)
INSERT [dbo].[Payment] ([id],[order_id],[User_id],[Paydate],[PaymentMethod],[Payee],[Amount]) VALUES (2, 2, 2,'2022/04/14','paypal','paypal',80000000)
INSERT [dbo].[Payment] ([id],[order_id],[User_id],[Paydate],[PaymentMethod],[Payee],[Amount]) VALUES (3, 3, 3,'2022/04/14','paypal','paypal',2000000)

SET IDENTITY_INSERT [dbo].[Payment] OFF


