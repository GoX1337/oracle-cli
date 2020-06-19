import io.quarkus.picocli.runtime.annotations.TopCommand;
import org.gox.command.DateCommand;
import org.gox.command.ItemCommand;
import picocli.CommandLine;

@TopCommand
@CommandLine.Command(mixinStandardHelpOptions = true, subcommands = {DateCommand.class, ItemCommand.class})
public class EntryCommand {
}

