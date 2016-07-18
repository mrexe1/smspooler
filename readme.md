SMS Pooler allows you to forward sms to another contact and also to public telegram channel and user id.

App Configuration
---
Configure - To Contact for SMS forward
Configure - To Channel for telegram message forwarding [copy the channel name]
Configure - BotId which will forward the message to the 'Channel'. Bot needs to be admin of that channel
Configure - Telgram User Ids for message forwarding 

Telegram Configuration for Bot and Public Channel
-------------------------------------------------
Configure a public channel
Configure a bot - https://core.telegram.org/bots [copy the bot-token]
Configure the bot as admin of the public channel

Telegram Configuration for User Id
----------------------------------
Search for the bot in telegram UI and message it 
Get conversation Data by invoking Telegram getUpdates api for the BOT - https://api.telegram.org/bot<BOT-TOKEN>/getUpdates
UserId is available in the output JSON - "id":160437079
{
    "ok":true,
    "result":[
     {
        "update_id":667905483,
        "message":
        {
            "message_id":29,
            "from":
            {
                "id":160437079,
                "first_name":"Sachin",
                "last_name":"R"},
                "chat":
                {
                    "id":160437079,
                    "first_name":"Sachin",
                    "last_name":"R",
                    "type":"private"
                },
                "date":1468821046,
                "text":"is this it"
             }
         }
      }
  }

Result
---
Only Banking SMSs are forwarded to another Phone Contact
All SMSs are forwarded to Telegram Channel and User Ids

Warning
---
Please avoid using default SMS , default channel and default bot id.