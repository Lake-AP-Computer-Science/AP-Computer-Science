package problem2;

import java.util.ArrayList;
import java.util.Comparator;

public class MailSorter {
	public static void SortMail(ArrayList<Mail> Mails, boolean Acending) //void bc modifs 'Mails' reference
	{	
		Mails.sort(new Comparator<Mail>()
		{
			@Override
			public int compare(Mail o1, Mail o2) {
				return o1.compareTo(o2) * (Acending ? 1 : -1);
			}
		});
	}
}
