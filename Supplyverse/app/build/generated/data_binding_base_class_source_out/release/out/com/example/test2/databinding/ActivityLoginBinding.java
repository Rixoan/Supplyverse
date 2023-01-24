// Generated by view binder compiler. Do not edit!
package com.example.test2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.test2.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialButton button;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final TextInputLayout etPass;

  @NonNull
  public final TextInputLayout etUsername;

  @NonNull
  public final ImageButton ibLoginBack;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final MaterialButton login;

  @NonNull
  public final ConstraintLayout loginForm;

  @NonNull
  public final TextView textView22;

  @NonNull
  public final TextView textView23;

  @NonNull
  public final TextInputEditText tvPassword;

  @NonNull
  public final TextView tvRegister;

  @NonNull
  public final TextInputEditText tvUsername;

  @NonNull
  public final View view;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull MaterialButton button,
      @NonNull CardView cardView, @NonNull TextInputLayout etPass,
      @NonNull TextInputLayout etUsername, @NonNull ImageButton ibLoginBack,
      @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2,
      @NonNull MaterialButton login, @NonNull ConstraintLayout loginForm,
      @NonNull TextView textView22, @NonNull TextView textView23,
      @NonNull TextInputEditText tvPassword, @NonNull TextView tvRegister,
      @NonNull TextInputEditText tvUsername, @NonNull View view) {
    this.rootView = rootView;
    this.button = button;
    this.cardView = cardView;
    this.etPass = etPass;
    this.etUsername = etUsername;
    this.ibLoginBack = ibLoginBack;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.login = login;
    this.loginForm = loginForm;
    this.textView22 = textView22;
    this.textView23 = textView23;
    this.tvPassword = tvPassword;
    this.tvRegister = tvRegister;
    this.tvUsername = tvUsername;
    this.view = view;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button;
      MaterialButton button = ViewBindings.findChildViewById(rootView, id);
      if (button == null) {
        break missingId;
      }

      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.et_pass;
      TextInputLayout etPass = ViewBindings.findChildViewById(rootView, id);
      if (etPass == null) {
        break missingId;
      }

      id = R.id.et_username;
      TextInputLayout etUsername = ViewBindings.findChildViewById(rootView, id);
      if (etUsername == null) {
        break missingId;
      }

      id = R.id.ib_login_back;
      ImageButton ibLoginBack = ViewBindings.findChildViewById(rootView, id);
      if (ibLoginBack == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.login;
      MaterialButton login = ViewBindings.findChildViewById(rootView, id);
      if (login == null) {
        break missingId;
      }

      ConstraintLayout loginForm = (ConstraintLayout) rootView;

      id = R.id.textView22;
      TextView textView22 = ViewBindings.findChildViewById(rootView, id);
      if (textView22 == null) {
        break missingId;
      }

      id = R.id.textView23;
      TextView textView23 = ViewBindings.findChildViewById(rootView, id);
      if (textView23 == null) {
        break missingId;
      }

      id = R.id.tv_password;
      TextInputEditText tvPassword = ViewBindings.findChildViewById(rootView, id);
      if (tvPassword == null) {
        break missingId;
      }

      id = R.id.tv_register;
      TextView tvRegister = ViewBindings.findChildViewById(rootView, id);
      if (tvRegister == null) {
        break missingId;
      }

      id = R.id.tv_username;
      TextInputEditText tvUsername = ViewBindings.findChildViewById(rootView, id);
      if (tvUsername == null) {
        break missingId;
      }

      id = R.id.view;
      View view = ViewBindings.findChildViewById(rootView, id);
      if (view == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, button, cardView, etPass,
          etUsername, ibLoginBack, linearLayout, linearLayout2, login, loginForm, textView22,
          textView23, tvPassword, tvRegister, tvUsername, view);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}