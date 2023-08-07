
Url : https://github.com/KavitaSupreeth/MusicStore.git
token : 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


========================Music Store Application ====================================
>>Import this project into your system

Users - can create as many user as you want -> Datatype- String
Store capacity for user - number of songs to be added for the user -> Datatype - Integer
Songs - can add as many songs as you want -> Datatype-  Queue<String>
Playlist - User and song mapping -> Datatype - Map<String, Queue<String>>
Recently played songs- limit is set by default to 4 -> Datatype - LinkedList<String>
Recent playlist - User and recently played songs -> Datatype - Map<String, LinkedList<String>>

-----How to Run-----

1) Select your choice from the menu
	1 for -> Creating new user
	2 for -> Playing songs for the user.(Select user from the user list)
	3 for -> Exit the music store.

2) Create User
	i) User name -> String value 
	ii) Store capacity -> Integer value
	(-ve & 0 Values are handled)
	iii) Enter songs equal to the store capacity eg: Store capacity=4,  Songs(s1,s2,s3,s4)

3) Play songs for user
	i) Select user from the user list 
	ii) Playlist of user is displayed as a recomendation for playing the songs
	iii) Enter the song name to be played from the Playlist or you can play any song of your choice
	iv) You can play as many songs as you want & songs will be saved to recent playlist
	v) *Note: size of recent playlist is 4 i.e only 4 recently played songs will be displayed and this recent 	   	    playlist will be updated as the user plays song.
