package net.myenv.changelang;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {


    Button btnEN, btnPL;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEN = findViewById(R.id.btnEn);
        btnPL = findViewById(R.id.btnPl);
        textView = findViewById(R.id.text);

        btnEN.setOnClickListener(view -> refreshAuto(LocaleManager.LANGUAGE_ENGLISH));
        btnPL.setOnClickListener(view -> refreshAuto(LocaleManager.LANGUAGE_POLISH));
        btnEN.setOnLongClickListener(view -> refreshManual(LocaleManager.LANGUAGE_ENGLISH));
        btnPL.setOnLongClickListener(view -> refreshManual(LocaleManager.LANGUAGE_POLISH));

        textView.setText(R.string.hello);

    }

    private boolean refreshManual(String lang) {
        Context context = LocaleManager.setNewLocale(this,lang);
        Resources resources = context.getResources();
        textView.setText(resources.getString(R.string.hello));
        return true;
    }

    public void refreshAuto(String lang) {
        LocaleManager.setNewLocale(this,lang);
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
        finish();
    }

}
