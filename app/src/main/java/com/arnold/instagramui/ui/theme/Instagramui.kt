package com.arnold.instagramui.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arnold.instagramui.R

@Composable
fun ProfileScreen() {
    Column (modifier =Modifier.fillMaxSize()){
   TopBar(name ="Arnold_Abeid" , modifier = Modifier.padding(10.dp))
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(4.dp))
        ButtonSection()
        
    }
}

@Composable
fun TopBar(
    name:String,
    modifier: Modifier= Modifier
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()

    ){
        Icon(imageVector = Icons.Default.ArrowBack ,
            contentDescription ="Back" ,
            tint= Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Text(text = name,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp

        )
        Icon(
            imageVector = Icons.Default.Notifications ,//painter is used ic-bell
            contentDescription ="Back" ,
            tint= Color.Black,
            modifier = Modifier.size(24.dp)
        )
        Icon(
            imageVector = Icons.Default.List ,//painter is used ic-dotmenu
            contentDescription ="Back" ,
            tint= Color.Black,
            modifier = Modifier.size(24.dp)
        ) 
    }
    
    
}

@Composable
fun ProfileSection(
    modifier: Modifier= Modifier
) {
   Column(modifier = Modifier.fillMaxHeight()) {
       Row (
           verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 20.dp)
       ){
           RoundImage(image = painterResource(id = R.drawable.aab),
               modifier = Modifier
                   .size(100.dp)
                   .weight(3F))
       Spacer(modifier = Modifier.width(16.dp))
           StatSection(modifier = Modifier.weight(7f))
       }
     ProfileDescription(displayName = "Programming Mentor ",
         description = "am arnold 2 years of coding experience\n"+
                       "want me to make your app? send me an email!\n" +
                         "subscribe to my Chanells" ,
         url ="https://youtube.com/c/arnoldabeid" ,
         followedBy = listOf("coding man", "Ramogippl"),
         otherCount = 17)
   }
}

@Composable
fun RoundImage(
    image:Painter,
    modifier: Modifier=Modifier
) {
    Image(painter = image,
        contentDescription = null,
        modifier= modifier
            //aspectRatio supposed to be here
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .padding(3.dp)
            .clip(CircleShape)
    )

}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
    ) {
      ProfileState(numberText = "600",   text = "posts")
      ProfileState(numberText = "100k",   text = "followers")
      ProfileState(numberText = "72",     text = "following")
    }
    
}

@Composable
fun ProfileState(
    numberText:String,
    text: String,
    modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
    ){
      Text(text = numberText,
          fontWeight = FontWeight.Bold,
          fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
      Text(text = text,
          modifier = Modifier.padding(4.dp)
          )
    }
}

@Composable
fun ProfileDescription(
    displayName: String,
    description: String,
    url:String,
    followedBy:List<String>,
    otherCount:Int,
    modifier: Modifier = Modifier) {
    val letterSpacing =0.5.sp
    val lineHeight =20.sp
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ){
      Text(text = displayName,
          fontWeight = FontWeight.Bold,
          letterSpacing= letterSpacing,
          lineHeight = lineHeight)
        Text(text = description,
          letterSpacing= letterSpacing,
          lineHeight = lineHeight)
        Text(text = url,
          color = Color(0xFF3D3D91) ,
          letterSpacing= letterSpacing,
          lineHeight = lineHeight)
        if(followedBy.isNotEmpty()){
            Text(text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                append("followed by")
                pushStyle(boldStyle)
                followedBy.forEachIndexed { index, name ->
                    pushStyle(boldStyle)
                    append(name)
                    pop()
                    if (index < followedBy.size-1) {
                        append(",")
                    }
                }
                if (otherCount>2) {
                    append("and")
                    pushStyle(boldStyle)
                    append("$otherCount others")


                }
            },
                letterSpacing = letterSpacing,
                lineHeight = lineHeight
            )
        }
    }
}

@Composable
fun ButtonSection(modifier: Modifier = Modifier) {
    val minWeight = 95.dp
    val height = 30.dp
    Row (
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
    ){
      ActionButton(text = "following",
                  icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minHeight = minWeight)
                .height(height)
      )
        ActionButton(text = "Message",
            modifier = Modifier
                .defaultMinSize(minHeight = minWeight)
                .height(height)
        )
        ActionButton(text = "Email",
            modifier = Modifier
                .defaultMinSize(minHeight = minWeight)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? =null,
    icon: ImageVector? =null
    ) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 5.dp,
                color = Color.Black,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)

    ){
      if (text !=null){
          Text(text = text,
              fontWeight = FontWeight.SemiBold,
              fontSize = 14.sp)
      }
        if (icon != null){
            Icon(imageVector = icon,
                contentDescription = null,
                tint = Color.Black)
        }
    }
}

//Highlight sectionkkiiokj
