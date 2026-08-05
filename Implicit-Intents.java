public class MainActivity extends AppCompatActivity {

    CardView clockCard ,stopClockCard ,cameraCard ,
            calenderCard ,contactCard ,gmailCard ,
            fileManagerCard ,mapCard ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clockCard = findViewById(R.id.cv_clock_card);
        stopClockCard = findViewById(R.id.cv_stop_clock);
        cameraCard = findViewById(R.id.cv_camera);
        calenderCard = findViewById(R.id.cv_calendar);
        contactCard = findViewById(R.id.cv_contact);
        gmailCard = findViewById(R.id.cv_gmail);
        fileManagerCard = findViewById(R.id.cv_file_manager);
        mapCard = findViewById(R.id.cv_map);


        clockCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        stopClockCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SHOW_TIMERS);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        calenderCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_APP_CALENDAR);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        cameraCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        contactCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
//                intent.setData(Uri.parse("content://contacts/people/"));

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        gmailCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,12);
//                Intent intent = getPackageManager()
//                        .getLaunchIntentForPackage("com.google.android.gm");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        fileManagerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setData(Uri.parse("image/*"));

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }

            }
        });
        mapCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("geo:0,0?q=Pakistan");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("geo:0,0?q=Pakistan"));

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }
}
