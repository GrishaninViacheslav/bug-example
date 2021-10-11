# bug-example

Если с помощью router.exit() вернуться с экрана DetailsFragment на экран MasterFragment, то при обновлении FragmentMasterBinding(в теле функции MasterFragment::showCount) перестаёт обновлятся, то что отображается на экране устрйоства(то есть FragmentMasterBinding не соответствует тому, что фактически отображается на экране). При этом после переворачивания экрана FragmentMasterBinding начинает соответствовать тому что отображается на экране.

Демонстрация бага: https://youtu.be/leWM1sLmA7g
